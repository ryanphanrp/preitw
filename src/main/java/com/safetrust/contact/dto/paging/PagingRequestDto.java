package com.safetrust.contact.dto.paging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.validation.constraints.Size;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagingRequestDto {
    @Size(min = 0, message = "Current page must not less than 0")
    Integer page;
    @Size(min = 1, message = "Page size must be more than 1")
    Integer pageSize;

    public Pageable toPageable() {
        if (Objects.isNull(this.page) || Objects.isNull(this.pageSize)) return Pageable.unpaged();
        return PageRequest.of(this.page, this.pageSize);
    }
}
