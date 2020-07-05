	.text
	.intel_syntax noprefix
	.file	"Shop.c"
	.globl	Shop_puzzled            # -- Begin function Shop_puzzled
	.p2align	4, 0x90
	.type	Shop_puzzled,@function
Shop_puzzled:                           # @Shop_puzzled
	.cfi_startproc
# %bb.0:
	sub	esp, 28
	.cfi_def_cfa_offset 32
	mov	eax, dword ptr [esp + 36]
	mov	ecx, dword ptr [esp + 32]
	mov	dword ptr [esp + 24], eax
	mov	eax, dword ptr [esp + 32]
	mov	eax, dword ptr [eax + 20]
	add	eax, 1
	mov	edx, dword ptr [esp + 32]
	mov	dword ptr [edx + 20], eax
	mov	eax, dword ptr [esp + 32]
	cmp	dword ptr [eax + 20], 3
	mov	dword ptr [esp + 20], ecx # 4-byte Spill
	jne	.LBB0_2
# %bb.1:
	mov	eax, dword ptr [esp + 32]
	mov	dword ptr [eax + 16], 9
	mov	eax, dword ptr [esp + 32]
	mov	eax, dword ptr [eax + 24]
	mov	ecx, dword ptr [esp + 24]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	Santa_puzzled
.LBB0_2:
	add	esp, 28
	ret
.Lfunc_end0:
	.size	Shop_puzzled, .Lfunc_end0-Shop_puzzled
	.cfi_endproc
                                        # -- End function
	.globl	Shop_enter              # -- Begin function Shop_enter
	.p2align	4, 0x90
	.type	Shop_enter,@function
Shop_enter:                             # @Shop_enter
	.cfi_startproc
# %bb.0:
	sub	esp, 28
	.cfi_def_cfa_offset 32
	mov	eax, dword ptr [esp + 36]
	mov	ecx, dword ptr [esp + 32]
	mov	dword ptr [esp + 24], eax
	mov	eax, dword ptr [esp + 32]
	mov	dword ptr [eax + 16], 10
	mov	eax, dword ptr [esp + 32]
	mov	eax, dword ptr [eax + 24]
	mov	edx, dword ptr [esp + 24]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], edx
	mov	dword ptr [esp + 20], ecx # 4-byte Spill
	call	Santa_enter
	add	esp, 28
	ret
.Lfunc_end1:
	.size	Shop_enter, .Lfunc_end1-Shop_enter
	.cfi_endproc
                                        # -- End function
	.globl	Shop_consult            # -- Begin function Shop_consult
	.p2align	4, 0x90
	.type	Shop_consult,@function
Shop_consult:                           # @Shop_consult
	.cfi_startproc
# %bb.0:
	sub	esp, 28
	.cfi_def_cfa_offset 32
	mov	eax, dword ptr [esp + 36]
	mov	ecx, dword ptr [esp + 32]
	mov	dword ptr [esp + 24], eax
	mov	eax, dword ptr [esp + 32]
	mov	eax, dword ptr [eax + 20]
	sub	eax, 1
	mov	edx, dword ptr [esp + 32]
	mov	dword ptr [edx + 20], eax
	mov	eax, dword ptr [esp + 32]
	cmp	dword ptr [eax + 20], 0
	mov	dword ptr [esp + 20], ecx # 4-byte Spill
	jle	.LBB2_2
# %bb.1:
	mov	eax, dword ptr [esp + 32]
	mov	dword ptr [eax + 16], 9
	jmp	.LBB2_3
.LBB2_2:
	mov	eax, dword ptr [esp + 32]
	mov	dword ptr [eax + 16], 8
.LBB2_3:
	mov	eax, dword ptr [esp + 32]
	mov	eax, dword ptr [eax + 24]
	mov	ecx, dword ptr [esp + 24]
	mov	dword ptr [esp], eax
	mov	dword ptr [esp + 4], ecx
	call	Santa_consult
	add	esp, 28
	ret
.Lfunc_end2:
	.size	Shop_consult, .Lfunc_end2-Shop_consult
	.cfi_endproc
                                        # -- End function

	.ident	"clang version 6.0.0-1ubuntu2 (tags/RELEASE_600/final)"
	.section	".note.GNU-stack","",@progbits
