@login
Feature: Authentification
  ETQ utilisateur je souhaite me connecter sur le site proservices

  @login_valid_credentials
  Scenario: Je souhaite me connecter avec des identifiants valides
    Given Je me connecte sur le site proservices
    When Je saisis le champ email
    And Je saisis le champ password
    And Je clique sur le boutton se connecter
    Then Je me redirige vers la page Home "Total des tickets"