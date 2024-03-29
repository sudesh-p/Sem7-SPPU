go:-
hypothesis(Disease),
write('It is suggested that the patient has '),
write(Disease),
nl,
undo;
write('Sorry, the system is unable to identify the disease'),nl,undo.


hypothesis(corona) :-
symptom(headache),
symptom(fever),
symptom(cough),
symptom(chills),
nl,
write('Advices and Sugestions:'),
nl,
write('1: Home Quarantine'),
nl,
write('2: Remdesivir'),
nl,
write('3: Wear Mask'),
nl,
write('Please contact nearest quarantine center because'),
nl,!.

hypothesis(jaundice) :-
symptom(yellowish_skin),
symptom(fever),
symptom(vomiting),
symptom(chills),
nl,
write('Advices and Sugestions:'),
nl,
write('1: Take Enough Rest'),
nl,
write('2: Drink Enough Fluids.'),
nl,
write('3: Eat Veggies'),
nl,
write('Please visit a doctor because'),
nl,!.

hypothesis(tonsilitis) :-
symptom(sore_throat),
symptom(poor_appetite),
symptom(weakness),
nl,
write('Advices and Sugestions:'),
nl,
write('1: Gargle with Salt Water'),
nl,
write('2: Avoid oily foods'),
nl,
write('3: Drink enough water'),
nl,
write('Take enough rest because'),
nl,!.

hypothesis(mumps) :-
symptom(fever),
symptom(swelling),
symptom(sweating),
symptom(jawlock),
nl,
write('Advices and Sugestions:'),
nl,
write('1: Quarantine'),
nl,
write('2: Bedrest'),
nl,
write('3: Apply Iodine Strips'),
nl,
write('Please contact a doctor because'),
nl,!.

hypothesis(cold) :-
symptom(headache),
symptom(runny_nose),
symptom(sneezing),
symptom(sore_throat),
nl,
write('Advices and Sugestions:'),
nl,
write('1: Tylenol'),
nl,
write('2: Panadol'),
nl,
write('3: Nasal spray'),
nl,
write('Please wear warm cloths because'),
nl,!.


hypothesis(influenza) :-
symptom(sore_throat),
symptom(fever),
symptom(headache),
symptom(chills),
symptom(body_ache),
nl,
write('Advices and Sugestions:'),
nl,
write('1: Tamiflu'),
nl,
write('2: Panadol'),
nl,
write('3: Zanamivir'),
nl,
write('Please take a warm bath and do salt gargling because'),
nl,!.


hypothesis(typhoid) :-
symptom(headache),
symptom(abdominal_pain),
symptom(poor_appetite),
symptom(fever),
nl,
write('Advices and Sugestions:'),
nl,
write('1: Chloramphenicol'),
nl,
write('2: Amoxicillin'),
nl,
write('3: Ciprofloxacin'),
nl,
write('4: Azithromycin'),
nl,
write('Please do complete bed rest and take soft diet because'),
nl,!.


hypothesis(chicken_pox) :-
symptom(rash),
symptom(body_ache),
symptom(fever),
nl,
write('Advices and Sugestions:'),
nl,
write('1: Varicella vaccine'),
nl,
write('2: Immunoglobulin'),
nl,
write('3: Acetomenaphin'),
nl,
write('4: Acyclovir'),
nl,
write('Please do have oatmeal bath and stay at home because'),
nl.


hypothesis(measles) :-
symptom(fever),
symptom(runny_nose),
symptom(rash),
symptom(conjunctivitis),
nl,
write('Advices and Sugestions:'),
nl,
write('1: Tylenol'),
nl,
write('2: Aleve'),
nl,
write('3: Advil'),
nl,
write('4: Vitamin A'),
nl,
write('Please get rest and use more liquid because'),
nl,!.


hypothesis(malaria) :-
symptom(fever),
symptom(sweating),
symptom(headache),
symptom(nausea),
symptom(vomiting),
symptom(diarrhea),
nl,
write('Advices and Sugestions:'),
nl,
write('1: Aralen'),
nl,
write('2: Qualaquin'),
nl,
write('3: Plaquenil'),
nl,
write('4: Mefloquine'),
nl,
write('Please do not sleep in open air and cover your full skin because'),
nl,!.


ask(Question) :-
write('Does the patient has the symptom '),
write(Question),
write('? : '),
read(Response),
nl,
( (Response == yes ; Response == y)
->
assert(yes(Question)) ;
assert(no(Question)), fail).
:- dynamic yes/1,no/1.

symptom(S) :-
(yes(S)
->true ;
(no(S)
->
fail ;
ask(S))).

undo :- retract(yes(_)),fail.
undo :- retract(no(_)),fail.
undo.