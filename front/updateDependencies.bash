#!/bin/bash

# Définition des dépendances de production à mettre à jour
dependencies=(
    "react"
    "react-dom"
    "react-redux"
    "redux"
)

# Définition des dépendances de développement à mettre à jour
devDependencies=(
    "@testing-library/jest-dom"
    "@testing-library/react"
    "@testing-library/user-event"
    "react-scripts"
    "web-vitals"
)

# Mise à jour des dépendances de production
for dep in "${dependencies[@]}"
do
    echo "Mise à jour de la dépendance de production $dep..."
    npm install "$dep@latest" --save
done

# Mise à jour des dépendances de développement
for dep in "${devDependencies[@]}"
do
    echo "Mise à jour de la dépendance de développement $dep..."
    npm install "$dep@latest" --save-dev
done

echo "Toutes les dépendances ont été mises à jour."
