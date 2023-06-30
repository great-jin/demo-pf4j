package cn.great.entity;

public class ElasticEntity {

    private String host;

    private int port;

    private boolean enableAuth;

    private String username;

    private String password;

    public ElasticEntity(Builder builder) {
        this.host = builder.host;
        this.port = builder.port;
        this.enableAuth = builder.enableAuth;
        this.username = builder.username;
        this.password = builder.password;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String host;

        private int port;

        private boolean enableAuth;

        private String username;

        private String password;

        public Builder host(String val) {
            this.host = val;
            return this;
        }

        public Builder port(int val) {
            this.port = val;
            return this;
        }


        public Builder enableAuth(boolean val) {
            this.enableAuth = val;
            return this;
        }

        public Builder username(String val) {
            this.username = val;
            return this;
        }

        public Builder password(String val) {
            this.password = val;
            return this;
        }

        public ElasticEntity build() {
            return new ElasticEntity(this);
        }
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public boolean isEnableAuth() {
        return enableAuth;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
