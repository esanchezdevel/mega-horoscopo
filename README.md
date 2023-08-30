# Mega-Horoscopo Readme

### CI/CD:
Only the production application.properties file is pushed into the repository.
The passwords and secret keys are stored as ``secrets`` in ``Github/Settings/Secrets``
The secrets has to be declared in the **Github Actions** build file.
Example:

      - name: Build and Deploy
        env:
          DB_PASSWORD: ${{ secrets.DB_PASSWORD }}  # Acceso al secreto
        run: |
          ./gradlew build
          java -jar build/libs/your-app.jar

