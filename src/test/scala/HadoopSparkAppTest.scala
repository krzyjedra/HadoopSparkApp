import org.scalatest._
import flatspec._
import matchers._
import org.apache.spark.sql.SparkSession

class HadoopSparkAppTest extends AnyFlatSpec with should.Matchers {
  "HadoopSparkApp" should "execute main" in {
    implicit val spark = SparkSession
      .builder()
      .master("local[*]")
      .appName("Spark SQL example")
      .getOrCreate()
    import spark.implicits._
    val actual = HadoopSparkApp.loadFilesFromPath("src/test/resources/files/").as[String]
    val expected = Seq("ABECADLO")

    HadoopSparkApp.main(Array("src/test/resources/files/"))
  }
}
