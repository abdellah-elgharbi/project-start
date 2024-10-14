

# Galerie des Stars du Football

## Objectifs du Projet

Ce projet consiste à développer une application Android présentant une galerie de stars du football avec les fonctionnalités suivantes :

- **Écran de démarrage animé** : avec des animations fluides.
- **Liste des stars de football** : possibilité de consulter et de filtrer par nom.
- **Utilisation de RecyclerView** : pour afficher efficacement la liste des stars.
- **Utilisation de bibliothèques** : telles que Glide et Picasso pour le chargement d'images.

## Fonctionnalités

1. **Écran de Démarrage Animé**
   - Rotation de 360° pendant 2 secondes.
   - Redimensionnement à 50% pendant 3 secondes.
   - Translation verticale de 1000 pixels pendant 2 secondes.
   - Disparition progressive sur 6 secondes.
   - Après 5 secondes, redirection vers la liste des stars.

2. **Liste des Stars du Football**
   - Utilisation de `RecyclerView` pour l'affichage d'une liste défilante.
   - Les données des stars sont modélisées avec des attributs tels que :
     - ID
     - Nom
     - Image

3. **Filtrage des Données**
   - Un champ de recherche permet de filtrer les stars par nom dans la liste.
   - L'interface `Filterable` est utilisée pour la recherche.

4. **Gestion des Images**
   - Les images des stars sont chargées via la bibliothèque **Glide** ou **Picasso**.
   - Utilisation de `CircleImageView` pour afficher les images en forme circulaire.

5. **Gestion des Menus**
   - Un menu avec une icône de recherche permet d'afficher dynamiquement les résultats filtrés dans la `RecyclerView`.

## Bibliothèques Utilisées

- **Glide** : pour le chargement rapide d'images avec gestion automatique du cache. [Documentation Glide](https://bumptech.github.io/glide/)
- **Picasso** : pour des chargements d'images simples et performants. [Documentation Picasso](https://square.github.io/picasso/)
- **Android-Gif-Drawable** : pour l'affichage fluide des GIFs animés. [Documentation Android-Gif-Drawable](https://github.com/koral--/android-gif-drawable)

## Installation

1. Cloner ce dépôt.
2. Ouvrir le projet dans Android Studio.
3. Ajouter les dépendances nécessaires dans le fichier `build.gradle` :
   ```gradle
   implementation 'com.github.bumptech.glide:glide:4.12.0'
   implementation 'com.squareup.picasso:picasso:2.71828'
   implementation 'pl.droidsonroids.gif:android-gif-drawable:1.2.22'
   implementation 'de.hdodenhof:circleimageview:3.1.0'
   ```
4. Exécuter l'application sur un appareil ou un émulateur Android.

## Résultats

- L'écran de démarrage avec les animations définies.
- La liste des stars de football avec leurs noms, images, et clubs.
- Filtrage en temps réel des stars via le champ de recherche.

---

