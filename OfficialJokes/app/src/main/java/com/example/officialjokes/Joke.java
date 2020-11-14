package com.example.officialjokes;

public class Joke {

    private String id;
    private String setup;
    private String punchline;
    private String type;

    public Joke(String id, String setup, String punchline, String type) {
        this.id = id;
        this.setup = setup;
        this.punchline = punchline;
        this.type = type;
    }

    public Joke() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
