package com.example.techlab.services;

import com.example.techlab.dto.ReactifDTO;

import java.util.List;

public interface ReactifService {
    public List<ReactifDTO> listeReactifs();

    public ReactifDTO ajouterReactif(ReactifDTO reactifDTO);

    public ReactifDTO obtenirReactifParId(Long idReactif);

    public ReactifDTO modifierReactif(Long idReactif, ReactifDTO reactifDTO);


    public void supprimerReactif(Long idReactif);
    public List<ReactifDTO> reactifExpire();
    public List<ReactifDTO> reactifReptureEnStock();

}
