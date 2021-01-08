package osmaha.universityhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import osmaha.universityhub.domain.Degree;

import java.util.List;

public interface DegreeRepository extends JpaRepository<Degree, Integer> {
    List<Degree> findAll();
}
