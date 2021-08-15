package pl.sdaproject.medicalarchivemanagementsystem.mapper;

import org.springframework.stereotype.Component;
import pl.sdaproject.medicalarchivemanagementsystem.dto.ArchiveCategoryResponse;
import pl.sdaproject.medicalarchivemanagementsystem.model.ArchiveCategory;

@Component
public class ArchiveCategoryMapper {

    public ArchiveCategoryResponse mapArchiveCategoryToArchiveCategoryResponse(ArchiveCategory archiveCategory) {

        return ArchiveCategoryResponse.builder()
                .categoryName(archiveCategory.getCategoryName())
                .storagePeriodYears(archiveCategory.getStoragePeriodYears())
                .build();
    }
}