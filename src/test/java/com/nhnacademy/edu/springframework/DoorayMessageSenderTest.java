package com.nhnacademy.edu.springframework;

import com.nhn.dooray.client.DoorayHookSender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class DoorayMessageSenderTest {

    @Mock
    private DoorayHookSender doorayHookSenderMock;

    private DoorayMessageSender doorayMessageSender;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        doorayMessageSender = new DoorayMessageSender(doorayHookSenderMock, "dummyHookUrl");
    }

    @Test
    public void testSendMessage_Success() {
        // Given
        User user = new User("John", "Doe");
        String message = "Test message";

        // When
        doNothing().when(doorayHookSenderMock).send(any());
        boolean result = doorayMessageSender.sendMessage(user, message);

        // Then
        assertTrue(result);
        verify(doorayHookSenderMock, times(1)).send(any());
    }

    @Test
    public void testSendMessage_Failure() {
        // Given
        User user = new User("Jane", "Doe");
        String message = "Test message";

        // When
        doThrow(new RuntimeException("Sending message failed")).when(doorayHookSenderMock).send(any());
        boolean result = doorayMessageSender.sendMessage(user, message);

        // Then
        assertFalse(result);
        verify(doorayHookSenderMock, times(1)).send(any());
    }
}
