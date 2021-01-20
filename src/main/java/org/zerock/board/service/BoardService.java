package org.zerock.board.service;

import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResultDTO;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Member;

public interface BoardService {

    // 게시글 등록
    Long register(BoardDTO dto);

    // 게시물 목록 처리
    PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

    // 게시글 조회 처리
    BoardDTO get(Long bno);

    // 게시글 삭제 처리
    void removeWithReplies(Long bno);

    // 게시글 수정 처리
    void modify(BoardDTO boardDTO);

    default Board dtoToEntity(BoardDTO dto) {
        Member member = Member.builder().email(dto.getWriterEmail()).build();

        Board board = Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();

        return board;
    }

    default BoardDTO entityToDto(Board board, Member member, Long replyCount) {

        BoardDTO boardDTO = BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .writerEmail(member.getEmail())
                .writerName(member.getName())
                .replyCount(replyCount.intValue())  // long 으로 나오므로 int로 처리
                .build();

        return boardDTO;

    }
}
