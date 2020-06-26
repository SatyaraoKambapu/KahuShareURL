package com.spireon.hackthon.kahuweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetTypeRefDto {
    private String code;
    private String name;
    private String description;


    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    // used by mappers
    @SuppressWarnings("unused")
    public AssetTypeRefDto() {
    }

    private AssetTypeRefDto(Builder builder) {
        this.code = builder.code;
        this.name = builder.name;
        this.description = builder.description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Builder builder() {
        return new Builder();
    }


    //AssetTypeRefDto Builder
    public static class Builder {

        private String code;
        private String name;
        private String description;

        private Builder() {
        }

        public Builder withCode(String code) {
            this.code = code;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public AssetTypeRefDto build() {
            return new AssetTypeRefDto(this);
        }
    }
}
