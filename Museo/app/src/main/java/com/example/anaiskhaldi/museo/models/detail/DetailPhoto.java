package com.example.anaiskhaldi.museo.models.detail;

/**
 * Created by Adeline on 17/07/2017.
 */

public class DetailPhoto {

    public String photo_reference;

    @Override
    public String toString() {
        return "DetailPhotos{" +
                "photo_reference='" + photo_reference + '\'' +
                '}';
    }

    public String getPhoto_reference() {
        return photo_reference;
    }

    public void setPhoto_reference(String photo_reference) {
        this.photo_reference = photo_reference;
    }

    /*
    "photos": [
            {
                "height": 1152,
                "html_attributions": [
                    "<a href=\"https://maps.google.com/maps/contrib/101968019975180514983/photos\">gary turner</a>"
                ],
                "photo_reference": "CmRaAAAAJzPqsFbyuQhQppCiiRs8_Obp_OyEhRa6j3MxvTN4mTx4z85A05CBZzHwCPZxuw9rnCSVSORH8s_jz50NHBQY3RBJDszK1pIRsJD_avSPwxjZ_u2KZLTP2Lin76LLnJ8BEhB06aq3M7ehNJWK7ruTMxZIGhRNprkTiI1CdVV9jBCeEBnhiaVBRA",
                "width": 2048
            },
            {
                "height": 2992,
                "html_attributions": [
                    "<a href=\"https://maps.google.com/maps/contrib/112038651345784647080/photos\">Lew Wilde</a>"
                ],
                "photo_reference": "CmRaAAAADz6YbQxI5QUnZ80L4BJPgtTkgZ5fDmsgZf7tBvWGcdfegwh6kOPoVBO0y51RtriAg9t5hLatYuwXkEv5zSt4sdOHWE8Q_RC6VWTIAPb3Qhkm6zxgPe-Q0I24eS6XBkFVEhAh3y5svyt7paIU0ZZxsTSJGhRm38aRuymqvcScN3WVPqKuBaKIPA",
                "width": 4000
            },
            {
                "height": 2368,
                "html_attributions": [
                    "<a href=\"https://maps.google.com/maps/contrib/113353687335434474166/photos\">Nevadatiti ch</a>"
                ],
                "photo_reference": "CmRaAAAAaBJAMwXsNRxnrcWEqv6R0gMb83ParfrDjRgYgOe6X8BXq-yDeLFGJb67rLKbBm1DvAoWVabKTPN8kqa2al5dV93-JPlTqwJw9ZaLDfMG_LbmW-sTQi7oLfezwq_EJ8g1EhC19WdRYhmtosnU1LbbeiAqGhSWr2OWnoorTpPA3Dzkv_pQzkaftw",
                "width": 4224
            },
            {
                "height": 1152,
                "html_attributions": [
                    "<a href=\"https://maps.google.com/maps/contrib/113265164721457911931/photos\">Annabel Galinie</a>"
                ],
                "photo_reference": "CmRaAAAAwEu8nUpFYxIdAdJMwYohWCQIy8g9_kOaAj0bZmVWlslS9SBMK-ElkNIdtqnFZ4uf29qVFrZU7AP6TPHMUYjy5X25xIFK4Wcw7xaa46qa_J3kHfquLUD48vZLnfR00FxSEhCszq1JdJz05vZ1711-ZY96GhS13WyGjgiwq0epZuYFqq2tmDX9ug",
                "width": 2048
            },
            {
                "height": 2368,
                "html_attributions": [
                    "<a href=\"https://maps.google.com/maps/contrib/113353687335434474166/photos\">Nevadatiti ch</a>"
                ],
                "photo_reference": "CmRaAAAAt7kRlJTod9JGORaoSA4erL27LbDSv9EDLqCEm_EbyuZG5hrNbC2ZibA8cDVKgEbsc4nzytLVgAM6ESs5cMkkgyyIwh3KaKNIvA3pFXDQQHEXnSVL2whtLK46UduYFcfuEhASp7--YHgJl31zyc89BPmhGhSUWg4C-iDkLQQGv8pZ1lJ5ChLsxQ",
                "width": 4224
            },
            {
                "height": 3024,
                "html_attributions": [
                    "<a href=\"https://maps.google.com/maps/contrib/104904851541949188379/photos\">Ivo Pereira-Junior</a>"
                ],
                "photo_reference": "CmRaAAAAqf9RIY2ybgLdRBRp8v4iau_lmKyOVxbJMbBpcoPZcq1LGenGy-tD9mnAu6iUEVT2ur0yyEdkRbVU5R_D3AISJgaDaXpxpXz1Fckdqhlwv6TLwPPDAIKOSdx2yAC77a7qEhAFJYbSpqcV8lMxOZCvLYeMGhTIYmL5Bbbeb1acxG9OssKbcQdRhw",
                "width": 4032
            },
            {
                "height": 1365,
                "html_attributions": [
                    "<a href=\"https://maps.google.com/maps/contrib/102004664284473292143/photos\">Choco-Story Paris - Musée du Chocolat</a>"
                ],
                "photo_reference": "CmRaAAAAWZR2qvVIXYl5ooF8-RfBW8lXMs584t2BlOBV5AO_39hSEuXThAOn3qi3KqwvccRVaaBH5yEliOxhMaW1_zqV505F2gbh52zYpEgp_GH5sHL1MFTaLGKMyspDwrf8OpmUEhChJln5jbmaHYuOyTmgxvVeGhQFTfk8XUcMbBU8Feq0Iscff3QVjg",
                "width": 2048
            },
            {
                "height": 3264,
                "html_attributions": [
                    "<a href=\"https://maps.google.com/maps/contrib/103698073470443878889/photos\">H F</a>"
                ],
                "photo_reference": "CmRaAAAAvEkidpHYImOgYOayqmEuxj8XOmc5911gkuV2TwnlRChcexBEd2TmbOnbxYepeZ0KD3qwHLLrI1eIK6QCJGZvul-6RZiB7x5wQRckSRDEacL0uGMq0-XSEHMizcdUVsC4EhAkh59-SzGptsKv-QE9BGrUGhQzCQml-HAreYcQX9pm-o8yoZA2aA",
                "width": 1836
            },
            {
                "height": 3024,
                "html_attributions": [
                    "<a href=\"https://maps.google.com/maps/contrib/109379187022510886282/photos\">Max Otea</a>"
                ],
                "photo_reference": "CmRaAAAAikDcDXOy3ErlaO9c19SKrkEpYS1oNPN3FRZPJClUrf6vSKneNwBBPBNewCNIG9RJlqD4ps8TTGawhBCAJ6mhn1euvvYNKSR8JU8pjkuEsB0r0OkVSwaZ-MIPmtx5H9f4EhB65O_BzBVHoKWqgFwkfeO8GhSzIGngrdRBR6fGREQg4rMqrM1x7A",
                "width": 4032
            },
            {
                "height": 2988,
                "html_attributions": [
                    "<a href=\"https://maps.google.com/maps/contrib/103825744938266180322/photos\">Shartrica Polk</a>"
                ],
                "photo_reference": "CmRaAAAAs_8ufS5drKx8qnVx4i7QyxD0JZoKeSF6c2wiZdxW6e1eEXaXViDnUS4vgnF2Sy8gKYmgKJu2WB370EepMR4WXVskfQm_ANggacyYr_3yVGXVW8QxDrYqOq1WL_rt9iFdEhCA8VfAK4YYziRVUyPG705zGhQzrG4I-3i5tZ3lLIdGshDSuuSYZQ",
                "width": 2988
            }
        ],
     */
}
