package com.haifachagwey.kafkaexample;

import java.time.LocalDateTime;

//public record Message(String message) {
//}
public record Message(String message, LocalDateTime created) {
}
