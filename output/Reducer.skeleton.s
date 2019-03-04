align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc

; global methods declare
global Reducer_init
; global Reducer_methods
; global methods declare

Reducer_init:
Reducer_init_realloc:
    PUSH DWORD 
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   Reducer_init_realloc
    ; init code goes here
    ; 
    ; init code ends here
    MOV  DWORD [EAX + 8], 0              		; unlock
    RET

Reducer_doactions:
Reducer_doactions_start:
    PUSH DWORD EBP
    ; CALL Reducer_action
    POP  EBP
    CALL switch_to_sched
    JMP  Reducer_doactions_start
    RET  ; never be here
    ;define method
Reducer_reduce1:
Reducer_reduce1_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(args)
Reducer_reduce1_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Reducer_reduce1_suspend
Reducer_reduce1_checkguard:
    ; method guard starts here
    ; 
    ; method guard ends here
Reducer_reduce1_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Reducer_reduce1_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Reducer_reduce1_start
Reducer_reduce1_succeed:
    ; method body starts here
    ; 
    ; method body ends here
Reducer_reduce1_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(args)
    PUSH DWORD EAX              ; for the return val
    PUSH DWORD EBP
    PUSH DWORD ECX
    CALL runqput
    POP  DWORD ECX
    POP  DWORD EBP
    POP  DWORD EAX              ; for the return val
    ; unlock
    MOV DWORD [ECX + 8], 0
Reducer_reduce1_ret:
    RET ;define method
Reducer_reduce2:
Reducer_reduce2_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(args)
Reducer_reduce2_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  Reducer_reduce2_suspend
Reducer_reduce2_checkguard:
    ; method guard starts here
    ; 
    ; method guard ends here
Reducer_reduce2_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
Reducer_reduce2_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  Reducer_reduce2_start
Reducer_reduce2_succeed:
    ; method body starts here
    ; 
    ; method body ends here
Reducer_reduce2_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(args)
    PUSH DWORD EAX              ; for the return val
    PUSH DWORD EBP
    PUSH DWORD ECX
    CALL runqput
    POP  DWORD ECX
    POP  DWORD EBP
    POP  DWORD EAX              ; for the return val
    ; unlock
    MOV DWORD [ECX + 8], 0
Reducer_reduce2_ret:
    RET ; define action
; Reducer: doReduce 
Reducer_action2:
Reducer_action2_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    ; 
    ; action guard end

    JE   Reducer_action2_guardfail
    ; action body start
    ; 
    ; action body end
Reducer_action2_guardfail:
    RET