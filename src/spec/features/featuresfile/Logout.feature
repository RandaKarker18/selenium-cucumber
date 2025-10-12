@Logout
Feature: Deconnexion reussie
  ETQ utilisateur je souhaite me deconnecter du site Proservices

  @logout_success
  Scenario: Je souhaite me deconnecter avec succes
    Given Je suis deja connecte
    When Je clique sur le bouton Avatar
    And Je clique sur le bouton Deconnexion
    Then Je suis redirige vers la page de connexion "Accéder à votre compte"

