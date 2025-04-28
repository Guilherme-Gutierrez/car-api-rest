package com.car.service.impl;

import com.car.domain.model.Carro;
import com.car.domain.repository.CarroRepository;
import com.car.service.CarService;
import com.car.service.exception.BusinessException;
import com.car.service.exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class CarServiceImpl implements CarService {

    private final CarroRepository carroRepository;

    public CarServiceImpl(CarroRepository carroRepository){
        this.carroRepository = carroRepository;
    }

    @Transactional
    public List<Carro> findAll() {
        return this.carroRepository.findAll();
    }

    @Transactional
    public Carro findById(Integer id) throws NotFoundException {
        return this.carroRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public Carro create(Carro carroParaCriar) {
        ofNullable(carroParaCriar).orElseThrow(() -> new BusinessException("O carro a ser criado não deve ser nulo."));
        ofNullable(carroParaCriar.getMotor()).orElseThrow(() -> new BusinessException("O motor não deve ser nulo."));

        return this.carroRepository.save(carroParaCriar);
    }

    @Transactional
    public Carro update(Integer id, Carro carroParaAtualizar) {
        Carro dbCarro = this.findById(id);
        if(!dbCarro.getId().equals(carroParaAtualizar.getId())){
            throw new BusinessException("Os IDs de atualização devem ser os mesmos");
        }

        dbCarro.setModelo(carroParaAtualizar.getModelo());
        dbCarro.setAno(carroParaAtualizar.getAno());
        dbCarro.setMarca(carroParaAtualizar.getMarca());
        dbCarro.setCategoria(carroParaAtualizar.getCategoria());
        dbCarro.setTracao(carroParaAtualizar.getTracao());
        dbCarro.setCambio(carroParaAtualizar.getCambio());
        dbCarro.setMotor(carroParaAtualizar.getMotor());
        dbCarro.setDimensoes(carroParaAtualizar.getDimensoes());
        dbCarro.setImagens(carroParaAtualizar.getImagens());

        return this.carroRepository.save(dbCarro);
    }

    @Transactional
    public void delete(Integer id) {
        Carro dbCarro = this.findById(id);
        this.carroRepository.delete(dbCarro);
    }
}
