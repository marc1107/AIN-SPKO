% Fakten
zug(konstanz, 08.39, offenburg, 10.59).
zug(konstanz, 08.39, karlsruhe, 11.49).
zug(konstanz, 09.06, singen, 09.31).
zug(singen, 09.36, stuttgart, 11.32).
zug(offenburg, 11.28, mannheim, 12.24).
zug(karlsruhe, 12.06, mainz, 13.47).
zug(stuttgart, 11.51, mannheim, 12.28).
zug(mannheim, 12.39, mainz, 13.18).

% Basisfall: Direkte Verbindung
verbindung(Start, AbfahrtszeitMin, Ziel, [zug(Start, Abfahrtszeit, Ziel, Ankunftszeit)]) :-
    zug(Start, Abfahrtszeit, Ziel, Ankunftszeit),
    Abfahrtszeit >= AbfahrtszeitMin.

% Rekursiver Fall: Verbindung mit Umsteigen
verbindung(Start, AbfahrtszeitMin, Ziel, [zug(Start, Abfahrtszeit, Zwischenhalt, Ankunftszeit) | Rest]) :-
    zug(Start, Abfahrtszeit, Zwischenhalt, Ankunftszeit),
    Abfahrtszeit >= AbfahrtszeitMin,
    verbindung(Zwischenhalt, Ankunftszeit, Ziel, Rest).
