sum([], 0).

sum([H|T], Sum) :-
    sum(T, RestSum),
    Sum is H + RestSum.