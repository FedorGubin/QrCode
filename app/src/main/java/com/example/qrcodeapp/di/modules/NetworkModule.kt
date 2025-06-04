package com.example.qrcodeapp.di.modules

import dagger.Module
import dagger.Provides
import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideEngine(): HttpClientEngineFactory<*> = OkHttp

    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
        isLenient = true
    }

    @Provides
    @Singleton
    fun provideLogger(): Logger = Logger.DEFAULT

    @Provides
    @Singleton
    fun provideLogLevel(): LogLevel = LogLevel.ALL

    @Provides
    @Singleton
    fun provideHttpClient(
        engine: HttpClientEngineFactory<*>,
        json: Json,
        logger: Logger,
        logLevel: LogLevel
    ): HttpClient {
        return HttpClient(engine) {
            install(ContentNegotiation) {
                json(json)
            }

            install(Logging) {
                this.logger = logger
                this.level = logLevel
            }
        }
    }
}
