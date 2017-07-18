DOJO : Blockchain API
==

**_Contexte_** : Votre client souhaite afficher sur son application le cours actuel du bitcoin.  

Bonne nouvelle : après quelques recherches, vous êtes tombé sur une API en ligne permettant de récupérer cette donnée.
<https://api.blockchain.info/stats>

Il s'agit de l'attribut **_market_price_usd_** dans le JSON retourné par l'API

```javascript
  {
    "market_price_usd": 1921.36,
    "hash_rate": 6318919966.63,
    "total_fees_btc": 16702126422,
    "n_btc_mined": 197500000000,
    "n_tx": 202382,
    "n_blocks_mined": 158,
    "minutes_between_blocks": 8.52,
    "totalbc": 1645138750000000,
    "n_blocks_total": 476111,
    "estimated_transaction_volume_usd": 452296888.13,
    "blocks_size": 132380692,
    "miners_revenue_usd": 4115609.96,
    "nextretarget": 477791,
    "difficulty": 804525194568,
    "estimated_btc_sent": 23540363671203,
    "miners_revenue_btc": 2142,
    "total_btc_sent": 195854651821504,
    "trade_volume_btc": 122899.74,
    "trade_volume_usd": 236135575.50,
    "timestamp": 1500233265000
    }
``` 

En route ! 
=

* Familiarisation avec la stack technique (Spring Boot / Java / Gradle) en utilisant Spring Initializr
<https://spring.io/guides/gs/spring-boot/>
* Initialisation du projet blockchain-api
<LIEN GITHUB>
* Consommer le service RESTFul GET <https://api.blockchain.info/stats> en s'inspirant du tuto : <https://spring.io/guides/gs/consuming-rest/>
* Comment écrire des tests avec une dépendance extérieure ?
  * En utilisant Mockito
  * En utilisant MockRestServiceServer : <https://objectpartners.com/2013/01/09/rest-client-testing-with-mockrestserviceserver/>
* Gérer les cas d'erreurs (Erreur 500, Erreur 404)
* Ecrire un controller REST permettant de récupérer les informations

