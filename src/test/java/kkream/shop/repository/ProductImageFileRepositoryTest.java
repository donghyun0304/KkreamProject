package kkream.shop.repository;

import kkream.shop.domain.ProductImageFile;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProductImageFileRepositoryTest {

    @Autowired
    public ProductImageFileRepository productImageFileRepository;



    @Test
    void findAllById() {
        //given
        List<ProductImageFile> fileList = new ArrayList<>();
        fileList.add(new ProductImageFile(12L, "activity.jpg", "a1.jpg"));
        productImageFileRepository.save(fileList);
        //when
        ProductImageFile findFile = productImageFileRepository.findById(fileList.get(0).getFileNumber()).get();
        //then
        assertThat(findFile.getFileNumber()).isEqualTo(fileList.get(0).getFileNumber());
    }

    @Test
    void save() {
        //given
        List<ProductImageFile> fileList = new ArrayList<>();
        fileList.add(new ProductImageFile(12L, "activity.jpg", "a1.jpg"));
        fileList.add(new ProductImageFile(12L, "shoes.jpg", "a2.jpg"));
        productImageFileRepository.save(fileList);
        //when
        List<ProductImageFile> findFileLists =
                productImageFileRepository.findAllByProductId(fileList.get(0).getProductId());
        //then
        assertThat(findFileLists.size()).isEqualTo(2);
    }
}