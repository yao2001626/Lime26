align 4
segment .data
segment .bss
segment .text
extern  switch_to_sched
extern  runqput
extern  malloc

; global methods declare
; global _Reducer_methods
global _Reducer_init 
global _Reducer_reduce1 
global _Reducer_reduce2 
; global methods declare

_Reducer_init:
_Reducer_init_realloc:
    PUSH DWORD 32768
    CALL malloc
    ADD  ESP, 4
    CMP  DWORD EAX, 0
    JE   _Reducer_init_realloc
    MOV  DWORD [EAX + 32768 - 1*4], 0    ; index 
    MOV  DWORD [EAX + 32768 - 2*4], 0    ; next 
    MOV  DWORD [EAX + 32768 - 3*4], 0    ; a1 
    MOV  DWORD [EAX + 32768 - 4*4], 0    ; a2 
    MOV  DWORD [EAX + 32768 - 5*4], 0    ; e1 
    MOV  DWORD [EAX + 32768 - 6*4], 0    ; e2 
    MOV  DWORD [EAX + 32768 - 40 + 12], 0    ; next
    MOV  DWORD [EAX + 32768 - 40 + 8], 0     ; lock
    LEA  ECX,  [EAX + 32768 - 40 - 4]
    MOV  DWORD [EAX + 32768 - 40 + 4], ECX   ; Pre ESP
    LEA  ECX,  [EAX + 32768 - 40]
    MOV  DWORD [EAX + 32768 - 40], ECX       ; Pre EBP
    LEA  ECX,  [_Reducer_doactions]
    MOV  DWORD [EAX + 32768 - 40 - 4], ECX   ; Reducer_doactions
    ADD  DWORD EAX, 32768 - 40
    PUSH DWORD EBP
    PUSH DWORD EAX
    CALL runqput
    POP  DWORD EAX
    POP  DWORD EBP
    ; init code goes here
    _Reducer_init_code 
    ; init code ends here
    RET

_Reducer_doactions:
_Reducer_doactions_start:
    PUSH DWORD EBP
    ; CALL Reducer_action
    CALL _Reducer_doReduce
    POP  EBP
    CALL switch_to_sched
    JMP  _Reducer_doactions_start
    RET  ; never be here;define method _Reducer_reduce1
_Reducer_reduce1:
_Reducer_reduce1_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
_Reducer_reduce1_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  _Reducer_reduce1_suspend
_Reducer_reduce1_checkguard:
    ; method guard starts here
    _Reducer_reduce1_guard
    ; method guard ends here
_Reducer_reduce1_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
_Reducer_reduce1_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  _Reducer_reduce1_start
_Reducer_reduce1_succeed:
    ; method body starts here
    _Reducer_reduce1_body
    ; method body ends here
_Reducer_reduce1_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
    PUSH DWORD EAX              ; for the return val
    PUSH DWORD EBP
    PUSH DWORD ECX
    CALL runqput
    POP  DWORD ECX
    POP  DWORD EBP
    POP  DWORD EAX              ; for the return val
    ; unlock
    MOV DWORD [ECX + 8], 0
_Reducer_reduce1_ret:
    RET ;define method _Reducer_reduce2
_Reducer_reduce2:
_Reducer_reduce2_start:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
_Reducer_reduce2_checklock:
    MOV  DWORD EAX, 1           ;lock
    XCHG EAX, [ECX + 8]
    CMP  DWORD EAX, 0
    JNE  _Reducer_reduce2_suspend
_Reducer_reduce2_checkguard:
    ; method guard starts here
    _Reducer_reduce2_guard
    ; method guard ends here
_Reducer_reduce2_checkguard_fail:
    MOV  DWORD [ECX + 8], 0     ; unlock
_Reducer_reduce2_suspend:
    PUSH DWORD EBP
    CALL runqput
    POP  EBP
    CALL switch_to_sched
    JMP  _Reducer_reduce2_start
_Reducer_reduce2_succeed:
    ; method body starts here
    _Reducer_reduce2_body
    ; method body ends here
_Reducer_reduce2_unlock:
    MOV  DWORD ECX, [ESP + 4 + 4*1]   ; + 4 * num(para)
    PUSH DWORD EAX              ; for the return val
    PUSH DWORD EBP
    PUSH DWORD ECX
    CALL runqput
    POP  DWORD ECX
    POP  DWORD EBP
    POP  DWORD EAX              ; for the return val
    ; unlock
    MOV DWORD [ECX + 8], 0
_Reducer_reduce2_ret:
    RET ; define action
; _Reducer: doReduce 
_Reducer_doReduce:
_Reducer_doReduce_start:
    MOV  DWORD ECX, [ESP + 4]
    ; action guard start
    _Reducer_doReduce_guard
    ; action guard end

    JMP   _Reducer_doReduce_checkguard_fail
_Reducer_doReduce_succeed:
    ; action body start
    _Reducer_doReduce_body
    ; action body end
_Reducer_doReduce_checkguard_fail:
    RET