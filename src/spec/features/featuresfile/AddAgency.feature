@addAgency @smoketest  @sanitytest
Feature: Ajouter une agence
  ETQ utilisateur je souhaite ajouter une agence sur la plateforme Proservices.
  
  Background:
    Given Je me connecte sur le site proservices
    When Je saisis le champ email
    And Je saisis le champ password
    And Je clique sur le boutton se connecter
    
 @addAgency_duplicate
 Scenario: Ajouter une nouvelle agence qui existe deja
    When Je clique sur le bouton Agences de page Home
    Then Je suis redirige vers la page de gestion des agences "Liste des agences"
    When Je clique sur le button Ajouter Agence
    Then une boite de dialog "Ajouter Agence" s'ouvre
    When Je saisis nom d'agence qui existe
    When Je clique sur le bouton Ajouter
    Then une boite de dialog d'erreur s'ouvre "merci de saisir un autre nom"
    When Je clique sur le button OK 
    Then Je trouve la boite de dialog "Ajouter Agence" ouverte
    When Je clique sur le button Annuler
    Then Agence n est pas ajoute a la liste des agences 