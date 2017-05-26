package com.glessit.neurofunky.service.converter;

import com.glessit.neurofunky.entity.News;
import com.glessit.neurofunky.rest.dto.NewsDto;
import com.google.common.collect.Sets;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ApplicationGenericConverter implements GenericConverter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Sets.newHashSet(
                new ConvertiblePair(News.class, NewsDto.class)
        );
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        return null;
    }
}
