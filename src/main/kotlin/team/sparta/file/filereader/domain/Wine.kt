package team.sparta.file.filereader.domain

import jakarta.persistence.*

@Entity
@Table(name = "wine")
class Wine (
    @Column(name = "name", nullable = false, unique = true)
    val name:String,
    @Column(name = "sweetness", nullable = false)
    val sweetness: Int,
    @Column(name = "acidity", nullable = false)
    val acidity: Int,
    @Column(name = "body", nullable = false)
    val body: Int,
    @Column(name = "tannin", nullable = false)
    val tannin: Int,
    @Column(name = "type", nullable = false)
    val type: String,
    @Column(name = "aroma", nullable = false)
    val aroma: String,
    @Column(name = "price", nullable = true)
    val price: Int?,
    @Column(name = "kind", nullable = true)
    val kind: String?,
    @Column(name = "style", nullable = true)
    val style: String?,
    @Column(name = "country", nullable = true)
    val country: String?,
    @Column(name = "region", nullable = true)
    val region: String?,
    @Column(name = "embedding", nullable = true)
    val embedding: String?=null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
)