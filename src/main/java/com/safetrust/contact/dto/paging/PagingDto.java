package com.safetrust.contact.dto.paging;

import com.safetrust.contact.constant.ResponseCode;
import com.safetrust.contact.dto.paging.MetaDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PagingDto<T> {
    private int code;
    private String message;
    private List<T> body;
    MetaDto meta;

    public PagingDto(ResponseCode resCode, Page<T> page) {
        this.body = page.getContent();
        this.code = resCode.getCode();
        this.message = resCode.getMessage();
        this.meta = new MetaDto(
                page.getTotalPages(),
                page.getPageable().getPageSize(),
                page.getPageable().getPageNumber()
        );
    }
}
