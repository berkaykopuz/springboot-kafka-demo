package net.kopuz.springboot.repository;

import net.kopuz.springboot.entity.WikimediaDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<WikimediaDB, Long> {

}
