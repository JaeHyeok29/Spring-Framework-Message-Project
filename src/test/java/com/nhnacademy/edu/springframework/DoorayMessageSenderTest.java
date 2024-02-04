package com.nhnacademy.edu.springframework;

import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.DoorayMessageSender;
import com.nhnacademy.edu.springframework.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;

import static org.mockito.Mockito.*;

public class DoorayMessageSenderTest {

    @Mock
    private DoorayHookSender doorayHookSenderMock;

    private DoorayMessageSender doorayMessageSender;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        doorayMessageSender = new DoorayMessageSender(doorayHookSenderMock, "mockHookUrl");
    }

    @Test
    public void testSendMessage_Success() {
        String message = "test message";
        User user = new User("testEmail", "testPhoneNumber");

        doNothing().when(doorayHookSenderMock).send(any());

        boolean result = doorayMessageSender.sendMessage(user, message);

        verify(doorayHookSenderMock, times(1)).send(any());
        assert result;
    }

    @Test
    public void testSendMessage_Failure() {
        String message = "test message";
        User user = new User("testEmail", "testPhoneNumber");

        doThrow(new RuntimeException("Failed to send message")).when(doorayHookSenderMock).send(any());

        boolean result = doorayMessageSender.sendMessage(user, message);

        verify(doorayHookSenderMock, times(1)).send(any());
        assert !result;
    }
}
