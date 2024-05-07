package com.example.service_chatgptbot1.models;

public class Luis {
    public String query;
    public Intent[] intents;
    public Entity[] entities;

    public static class Intent {
        public String intent;
        public float score;
    }

    public static class Entity {
        public String entity;
        public String type;
        public int startIndex;
        public int endIndex;
        public float score;
    }
}
