package com.nhnacademy.edu.springframework;

import com.nhn.dooray.client.DoorayHookSender;
import com.nhn.dooray.client.DoorayHook;
import com.nhnacademy.edu.springframework.DoorayMessageSender;
import com.nhnacademy.edu.springframework.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

public class DoorayMessageSenderTest {

    @Test
    public void testSendMessage_Success() {
        // Mock 객체 생성
        DoorayHookSender doorayHookSenderMock = Mockito.mock(DoorayHookSender.class);

        // Mock 객체에 대한 행동 설정
        doNothing().when(doorayHookSenderMock).send(any());

        // 테스트할 대상 객체 생성
        DoorayMessageSender doorayMessageSender = new DoorayMessageSender(doorayHookSenderMock, "testHookUrl");

        // 테스트 데이터 설정
        User user = new User("testFirstName", "testLastName");
        String message = "testMessage";

        // 테스트 메서드 호출
        boolean result = doorayMessageSender.sendMessage(user, message);

        // 결과 검증
        assertTrue(result);
    }

    @Test
    public void testSendMessage_Failure() {
        // Mock 객체 생성
        DoorayHookSender doorayHookSenderMock = Mockito.mock(DoorayHookSender.class);

        // Mock 객체에 대한 행동 설정
        doThrow(new RuntimeException()).when(doorayHookSenderMock).send(any());

        // 테스트할 대상 객체 생성
        DoorayMessageSender doorayMessageSender = new DoorayMessageSender(doorayHookSenderMock, "testHookUrl");

        // 테스트 데이터 설정
        User user = new User("testFirstName", "testLastName");
        String message = "testMessage";

        // 테스트 메서드 호출
        boolean result = doorayMessageSender.sendMessage(user, message);

        // 결과 검증
        assertFalse(result);
    }
}
