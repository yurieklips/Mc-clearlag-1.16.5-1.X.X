# ClearLag Plugin

ClearLag est un plugin Minecraft conçu pour réduire le lag sur votre serveur. Il supprime automatiquement les items au sol ainsi que les entités hostiles toutes les 15 minutes.

Le plugin dispose des fonctionnalités suivantes :
- Exécution automatique toutes les 15 minutes (900 secondes)
- Envoi de messages de compte à rebours dans le chat aux 60, 30 et 10 secondes précédant le nettoyage
- Suppression des items au sol et des entités hostiles lors du nettoyage automatique ou manuellement via la commande `/clearlag`
- Message de bienvenue personnalisé (en bleu) affiché uniquement pour le joueur lors de sa connexion, indiquant que « Le clearLag de KarmaIsBack est utilisé sur ce serveur »
- Compatible avec Minecraft à partir de la version 1.16.5

## Installation et Compilation

### Avec un IDE (Eclipse, IntelliJ)
1. Importez le projet dans votre IDE.
2. Ajoutez l'API Spigot/Bukkit à votre build path.
3. Compilez le projet et exportez-le en fichier JAR.
4. Placez le fichier JAR dans le dossier `plugins` de votre serveur Minecraft.
5. Redémarrez le serveur ou utilisez la commande `/reload`.

### Avec Maven en ligne de commande
1. Placez les fichiers sources dans `src/main/java` et le fichier `plugin.yml` dans `src/main/resources`.
2. Exécutez la commande `mvn clean package`.
3. Le JAR sera généré dans le dossier `target`.
4. Copiez le JAR dans le dossier `plugins` de votre serveur Minecraft et redémarrez le serveur.

## Utilisation

- Le plugin s'exécute automatiquement toutes les 15 minutes et affiche les messages de compte à rebours dans le chat aux 60, 30 et 10 secondes avant le nettoyage.
- Lorsqu'un joueur se connecte, il reçoit un message personnalisé en bleu indiquant que « Le clearLag de KarmaIsBack est utilisé sur ce serveur ».
- Pour lancer manuellement le nettoyage, utilisez la commande : `/clearlag`.

## Licence

Distribué sous licence MIT. Consultez le fichier LICENSE pour plus de détails.
