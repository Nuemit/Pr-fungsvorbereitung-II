# Repository Mirroring Setup / Repository-Spiegelung Einrichten

Dieses Repository ist so konfiguriert, dass es automatisch auf ein anderes Repository gespiegelt wird.

## Einrichtung / Setup

Um die automatische Spiegelung zu aktivieren, müssen Sie ein Secret in den Repository-Einstellungen konfigurieren:

### Schritt 1: Ziel-Repository erstellen
1. Erstellen Sie ein neues Repository auf GitHub, GitLab oder einem anderen Git-Hosting-Dienst
2. Notieren Sie sich die Repository-URL

### Schritt 2: Personal Access Token erstellen
1. Gehen Sie zu Ihren GitHub Settings → Developer Settings → Personal Access Tokens → Tokens (classic)
2. Klicken Sie auf "Generate new token (classic)"
3. Geben Sie dem Token einen Namen (z.B. "Mirror Token")
4. Wählen Sie die folgenden Berechtigungen:
   - `repo` (vollständiger Zugriff auf Repositories)
5. Klicken Sie auf "Generate token"
6. Kopieren Sie den Token (Sie können ihn nur einmal sehen!)

### Schritt 3: Secret konfigurieren
1. Gehen Sie zu diesem Repository auf GitHub
2. Klicken Sie auf "Settings" → "Secrets and variables" → "Actions"
3. Klicken Sie auf "New repository secret"
4. Name: `MIRROR_URL`
5. Value: Die URL Ihres Ziel-Repositories mit Token im Format:
   ```
   https://username:TOKEN@github.com/username/target-repo.git
   ```
   Oder für GitLab:
   ```
   https://username:TOKEN@gitlab.com/username/target-repo.git
   ```
6. Klicken Sie auf "Add secret"

## Funktionsweise / How it Works

Die GitHub Action wird automatisch ausgelöst bei:
- Jedem Push auf einen Branch
- Beim Löschen eines Branches
- Beim Erstellen von Tags

Die Action spiegelt dann:
- Alle Branches
- Alle Tags
- Die komplette Git-Historie

## Beispiel-URLs / Example URLs

### GitHub zu GitHub:
```
https://nuemit:ghp_xxxxxxxxxxxxxxxxxxxxx@github.com/nuemit/target-repository.git
```

### GitHub zu GitLab:
```
https://nuemit:glpat-xxxxxxxxxxxxxxxxxxxxx@gitlab.com/nuemit/target-repository.git
```

### GitHub zu Bitbucket:
```
https://nuemit:xxxxxxxxxxxxxxxxxxxxx@bitbucket.org/nuemit/target-repository.git
```

## Fehlerbehebung / Troubleshooting

### "MIRROR_URL secret is not set"
Das Secret wurde nicht konfiguriert. Folgen Sie Schritt 3 oben.

### "Authentication failed"
- Überprüfen Sie, ob der Token noch gültig ist
- Stellen Sie sicher, dass der Token die richtigen Berechtigungen hat
- Überprüfen Sie, ob Username und Token korrekt in der URL eingegeben wurden

### "Repository not found"
- Stellen Sie sicher, dass das Ziel-Repository existiert
- Überprüfen Sie die URL auf Tippfehler
- Stellen Sie sicher, dass Sie Zugriff auf das Ziel-Repository haben

## Sicherheitshinweise / Security Notes

⚠️ **Wichtig:** Geben Sie niemals Ihr Token im Klartext weiter oder committen Sie es ins Repository!
- Verwenden Sie immer GitHub Secrets für sensible Daten
- Tokens sollten nur die minimal notwendigen Berechtigungen haben
- Erstellen Sie separate Tokens für verschiedene Zwecke

## Workflow Status

Sie können den Status der Spiegelung in der "Actions" Tab dieses Repositories überprüfen.
