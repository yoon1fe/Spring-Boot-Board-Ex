package org.zerock.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * 전달되는 목록에 관련된 데이터에 대한 DTO eg. 페이지 번호, 페이지 내 목록 개수, 검색 조건 등
 */

@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {

    private int page;
    private int size;
    // 서버 사이드에서 검색 처리를 위한 변수
    private String type;
    private String keyword;

    public PageRequestDTO(){
        this.page = 1;
        this.size = 10;
    }

    public Pageable getPageable(Sort sort){
        return PageRequest.of(page - 1, size, sort);
    }
}
