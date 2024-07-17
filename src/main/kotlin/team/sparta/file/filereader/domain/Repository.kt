package team.sparta.file.filereader.domain

import org.springframework.data.jpa.repository.JpaRepository


interface Repository: JpaRepository<Wine,Long> {
}