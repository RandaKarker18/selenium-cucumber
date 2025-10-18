pipeline {
    agent any

    environment {
        // variables d'environnement pour les credentials
        HOME_URL = 'https://adiat-front-formation.vercel.app'
        HOME_USERNAME = credentials('home-creds') // ID d'un secret Jenkins
        HOME_PASSWORD = credentials('home-creds') // ID d'un secret Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Create properties file') {
            steps {
                script {
                    // Crée le dossier si besoin
                    bat 'if not exist src\\test\\resources\\configs mkdir src\\test\\resources\\configs'

                    // Crée le fichier properties
                    bat '''
(
echo home.url=%HOME_URL%
echo home.username=%HOME_USERNAME%
echo home.password=%HOME_PASSWORD%
echo ticket.departement=MonDep
echo ticket.titre=titre
echo ticket.description=description
echo ticket.responsabel=responsable
echo agency.duplicatename=selenium-cucumber
) > src\\test\\resources\\configs\\env-config.properties
                    '''
                    
                    bat 'type src\\test\\resources\\configs\\env-config.properties'
                }
            }
        }

        stage('Run Maven Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            // Nettoyage du fichier properties
            bat 'del /f /q src\\test\\resources\\configs\\env-config.properties'
        }
    }
}
