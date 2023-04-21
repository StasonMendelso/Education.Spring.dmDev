package org.stanislav.spring.dto;

import lombok.Value;

import java.lang.invoke.TypeDescriptor;
import java.util.List;

/**
 * @author Stanislav Hlova
 */
@Value
public class PageResponse<T> {
    List<T> content;
    Metadata metadata;

    public static <T> PageResponse<T> of(List<T> content) {
        //var metadata = new Metadata(page.getNumber(), page.getSize(), page.getTotalElements());
        var metadata = new Metadata(0,0,0);
        return new PageResponse<>(content, metadata);
    }

    @Value
    public static class Metadata {
        int page;
        int size;
        long totalElements;
    }
}
