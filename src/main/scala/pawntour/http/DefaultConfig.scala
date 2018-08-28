package pawntour.http

import com.typesafe.config.{Config, ConfigFactory}

object DefaultConfig {

  lazy val config: Config = ConfigFactory.load()

  lazy val httPort: Int = config.getInt("http.port")
}
