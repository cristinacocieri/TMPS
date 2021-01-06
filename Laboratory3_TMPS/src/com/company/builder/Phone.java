package com.company.builder;

public class Phone {

    public static class Builder {
        private String Panel;
        private String processor;
        private String camera;

        public Builder() {
        }

        public Phone build() {
            return new Phone(this);
        }

        public Builder Panel(String frontPanel) {
            this.Panel = frontPanel;
            return this;
        }

        public Builder processor(String processor) {
            this.processor = processor;
            return this;
        }

        public Builder camera(String camera) {
            this.camera = camera;
            return this;
        }


    }

    private String Panel;
    private String Processor;
    private String Camera;

    private Phone(Builder builder) {
        this.Panel = builder.Panel;
        this.Processor = builder.processor;
        this.Camera = builder.camera;
    }

    public String getPanel() {
        return Panel;
    }

    public String getProcessor() {
        return Processor;
    }

    public String getCamera() {
        return Camera;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Phone{");
        sb.append("Panel='").append(Panel).append('\'');
        sb.append(", Processor='").append(Processor).append('\'');
        sb.append(", Camera='").append(Camera).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
