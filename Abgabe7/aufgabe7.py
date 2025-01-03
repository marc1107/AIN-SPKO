import requests

def get_holidays(year, state):
    """
    Ruft Feiertage für ein bestimmtes Jahr und Bundesland von der API ab.
    """
    url = f"https://feiertage-api.de/api/?jahr={year}&nur_land={state}"
    try:
        response = requests.get(url)
        response.raise_for_status()  # Fehler bei HTTP-Statuscodes erkennen
        holidays = response.json()
        return holidays
    except requests.exceptions.RequestException as e:
        print(f"Fehler bei der Anfrage: {e}")
        return None

def main():
    """
    Hauptfunktion zur Eingabe und Ausgabe der Feiertage.
    """
    year = input("Geben Sie das Jahr ein (z. B. 2025): ")
    state = input("Geben Sie das Bundesland ein (z. B. BW für Baden-Württemberg): ")

    holidays = get_holidays(year, state)
    if holidays:
        print(f"\nFeiertage in {state} im Jahr {year}:\n")
        for name, details in holidays.items():
            print(f"{name}: {details['datum']}")
    else:
        print("Keine Feiertage gefunden oder ein Fehler ist aufgetreten.")

if __name__ == "__main__":
    main()
