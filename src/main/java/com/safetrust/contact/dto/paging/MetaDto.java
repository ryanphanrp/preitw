package com.safetrust.contact.dto.paging;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MetaDto {
    Integer total;
    Integer pageSize;
    Integer current;
}
