package zerobase.weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zerobase.weather.domain.Memo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JpaMemoRepositoryTest {


    @Autowired
    JpaMemoRepository jpaMemoRepository;


    @Test
    void insertMemoTest(){

        //given
        Memo newMemo = new Memo(10, "hi");

        //when
        jpaMemoRepository.save(newMemo);

        //then
        List<Memo> memoList = jpaMemoRepository.findAll();
        assertTrue(memoList.size() > 0);
    }

    @Test
    void findByIdTest(){
        //given
        Memo newMemo = new Memo(44, "재영");
        //when
        jpaMemoRepository.save(newMemo);
        //then
        Optional<Memo> memo = jpaMemoRepository.findById(44);
        assertEquals(memo.get().getText(), "재영");
    }
}