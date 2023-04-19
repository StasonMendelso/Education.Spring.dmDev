package org.stanislav.spring.dto;

import lombok.Value;

import java.util.List;

/**
 * @author Stanislav Hlova
 */
@Value
public class PageResponse<T> {
    List<T> content;
    Metadata metadata;

    @Value
    public static class Metadata {
        int page;
        int size;
        long totalElements;
    }
}
