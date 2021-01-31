# MovementPermit
Hua essay in Distributed Systems

Αυτό το σύστημα τρέχει σε Eclipse IDE και είναι maven project 
Για να τρέξει η εφαρμογή πρέπει να κάνετε clone project από το git και να την κάνετε import 
σαν File System.  

Η βάση χρησιμοποιεί την MySql, έκδοση 8.0.21

Για να τρέξει το σύστημα πρέπει να υπάρχει στη βάση το schema MovementPermit και οι πίνακες 

user με πεδία username, password και enabled (primary key username)

authorities με username, authority (foreign key username)

form με πεδία fid, username, type, street, city, state, postalcode, ReqDate και approved 
