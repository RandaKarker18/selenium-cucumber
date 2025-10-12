@createTicket @smoketest  @sanitytest
Feature: Creation d'un Ticket
  ETQ utilisateur je souhaite creer un ticket sur la plateforme Proservices.
  
  Background:
    Given Je me connecte sur le site proservices
    When Je saisis le champ email
    And Je saisis le champ password
    And Je clique sur le boutton se connecter
    
 @createTicket_valid
 Scenario: Creation reussie d'un nouveau ticket
    When Je clique sur le bouton Creation Ticket de page Home
    Then Je suis redirige vers la page de creation de ticket "Nouveau Ticket"
    When Je saisis tous les champs obligatoires
    And Je clique sur le bouton creation ticket
    Then Le ticket est cree avec succes
    And Le ticket apparait dans la liste des tickets
    
  @createTicket_invalid
  Scenario: Creation invalide d'un nouveau ticket : manque un champ obligatoir
	When Je clique sur le bouton Creation Ticket de page Home
    Then Je suis redirige vers la page de creation de ticket "Nouveau Ticket"
	When Je ne saisie pas un champ obligatoire
	And Je clique sur le bouton creation ticket
	Then Un message d'erreur est affiche
	And Le ticket n est pas cree  
   