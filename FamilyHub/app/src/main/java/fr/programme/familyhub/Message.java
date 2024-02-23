package fr.programme.familyhub;


class Message {
    // Attributs de la classe Message
    private String sender; // Expéditeur 
    private String receiver; // Destinataire 
    private String content; // Contenu 

    // Constructeur de la classe Message
    public Message(String sender, String receiver, String content) {
        this.sender = sender; // Initialise l'expéditeur 
        this.receiver = receiver; // Initialise le destinataire 
        this.content = content; // Initialise le contenu
    }

    // Méthode pour obtenir le nom de l'expéditeur
    public String getSender() {
        return sender; // Retourne le nom de l'expéditeur
    }

    // Méthode pour obtenir le nom du destinataire
    public String getReceiver() {
        return receiver; // Retourne le nom du destinataire
    }

    // Méthode pour obtenir le contenu du message
    public String getContent() {
        return content; // Retourne le contenu du message
    }

    // Méthode pour représenter le message sous forme de chaîne de caractères
    @Override
    public String toString() {
        // Retourne une chaîne de caractères formatée représentant le message
        return "From: " + sender + "\nTo: " + receiver + "\nMessage: " + content;
    }
}