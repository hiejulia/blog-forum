package com.project.blogforum.util;


import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

@Service
public class MarkdownService {

    private Invocable invocable;

    public MarkdownService() {
        try {
            invocable = loadMarkdownEngine();
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    // Load markdown engine
    private Invocable loadMarkdownEngine() throws ScriptException {
        // Add tracem
//        trace("Loading JS engine (nashorn)");
        InputStream inputStream = BlogService.class.getClassLoader().getResourceAsStream("javascript/marked.min.js");

        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("nashorn");

        engine.eval(new InputStreamReader(inputStream));

        return (Invocable) engine;
    }

    // Render markdown function
    public String renderMarkdown(String markdown) {
        if (markdown == null || markdown.isEmpty()) {
            return "";
        }
        if (invocable != null) {
            try {
                Object result = invocable.invokeFunction("marked", markdown);
                return result.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
//            warn("JavaScript Markdown engine is not loaded!");
        }

        return markdown;
    }

}