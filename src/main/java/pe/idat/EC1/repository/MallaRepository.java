package pe.idat.EC1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.idat.EC1.model.Malla;

@Repository
public interface MallaRepository extends JpaRepository<Malla, Integer> {

}
