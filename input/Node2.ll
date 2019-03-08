; ModuleID = 'Node2.c'
source_filename = "Node2.c"
target datalayout = "e-m:e-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

%struct.Node2_struct = type { i32, i32, i32, i32, i32, i32, %struct.Node2_struct*, %struct.Node2_struct*, i32 }

; Function Attrs: noinline nounwind optnone uwtable
define void @Node2_add(i32, %struct.Node2_struct*) #0 {
  %3 = alloca i32, align 4
  %4 = alloca %struct.Node2_struct*, align 8
  store i32 %0, i32* %3, align 4
  store %struct.Node2_struct* %1, %struct.Node2_struct** %4, align 8
  %5 = load %struct.Node2_struct*, %struct.Node2_struct** %4, align 8
  %6 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %5, i32 0, i32 6
  %7 = load %struct.Node2_struct*, %struct.Node2_struct** %6, align 8
  %8 = icmp ne %struct.Node2_struct* %7, null
  br i1 %8, label %9, label %39

; <label>:9:                                      ; preds = %2
  %10 = load %struct.Node2_struct*, %struct.Node2_struct** %4, align 8
  %11 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %10, i32 0, i32 8
  store i32 1, i32* %11, align 8
  %12 = load i32, i32* %3, align 4
  %13 = load %struct.Node2_struct*, %struct.Node2_struct** %4, align 8
  %14 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %13, i32 0, i32 5
  store i32 %12, i32* %14, align 4
  %15 = load %struct.Node2_struct*, %struct.Node2_struct** %4, align 8
  %16 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %15, i32 0, i32 5
  %17 = load i32, i32* %16, align 4
  %18 = load %struct.Node2_struct*, %struct.Node2_struct** %4, align 8
  %19 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %18, i32 0, i32 4
  %20 = load i32, i32* %19, align 8
  %21 = icmp sle i32 %17, %20
  br i1 %21, label %22, label %29

; <label>:22:                                     ; preds = %9
  %23 = load %struct.Node2_struct*, %struct.Node2_struct** %4, align 8
  %24 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %23, i32 0, i32 5
  %25 = load i32, i32* %24, align 4
  %26 = load %struct.Node2_struct*, %struct.Node2_struct** %4, align 8
  %27 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %26, i32 0, i32 6
  %28 = load %struct.Node2_struct*, %struct.Node2_struct** %27, align 8
  call void @Node2_add(i32 %25, %struct.Node2_struct* %28)
  br label %36

; <label>:29:                                     ; preds = %9
  %30 = load %struct.Node2_struct*, %struct.Node2_struct** %4, align 8
  %31 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %30, i32 0, i32 5
  %32 = load i32, i32* %31, align 4
  %33 = load %struct.Node2_struct*, %struct.Node2_struct** %4, align 8
  %34 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %33, i32 0, i32 7
  %35 = load %struct.Node2_struct*, %struct.Node2_struct** %34, align 8
  call void @Node2_add(i32 %32, %struct.Node2_struct* %35)
  br label %36

; <label>:36:                                     ; preds = %29, %22
  %37 = load %struct.Node2_struct*, %struct.Node2_struct** %4, align 8
  %38 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %37, i32 0, i32 8
  store i32 0, i32* %38, align 8
  br label %86

; <label>:39:                                     ; preds = %2
  %40 = load i32, i32* %3, align 4
  %41 = load %struct.Node2_struct*, %struct.Node2_struct** %4, align 8
  %42 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %41, i32 0, i32 4
  %43 = load i32, i32* %42, align 8
  %44 = icmp slt i32 %40, %43
  br i1 %44, label %45, label %63

; <label>:45:                                     ; preds = %39
  %46 = load i32, i32* %3, align 4
  %47 = call i32 (i32, ...) bitcast (i32 (...)* @Node2_init to i32 (i32, ...)*)(i32 %46)
  %48 = sext i32 %47 to i64
  %49 = inttoptr i64 %48 to %struct.Node2_struct*
  %50 = load %struct.Node2_struct*, %struct.Node2_struct** %4, align 8
  %51 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %50, i32 0, i32 6
  store %struct.Node2_struct* %49, %struct.Node2_struct** %51, align 8
  %52 = load %struct.Node2_struct*, %struct.Node2_struct** %4, align 8
  %53 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %52, i32 0, i32 4
  %54 = load i32, i32* %53, align 8
  %55 = call i32 (i32, ...) bitcast (i32 (...)* @Node2_init to i32 (i32, ...)*)(i32 %54)
  %56 = sext i32 %55 to i64
  %57 = inttoptr i64 %56 to %struct.Node2_struct*
  %58 = load %struct.Node2_struct*, %struct.Node2_struct** %4, align 8
  %59 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %58, i32 0, i32 7
  store %struct.Node2_struct* %57, %struct.Node2_struct** %59, align 8
  %60 = load i32, i32* %3, align 4
  %61 = load %struct.Node2_struct*, %struct.Node2_struct** %4, align 8
  %62 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %61, i32 0, i32 4
  store i32 %60, i32* %62, align 8
  br label %85

; <label>:63:                                     ; preds = %39
  %64 = load i32, i32* %3, align 4
  %65 = load %struct.Node2_struct*, %struct.Node2_struct** %4, align 8
  %66 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %65, i32 0, i32 4
  %67 = load i32, i32* %66, align 8
  %68 = icmp sgt i32 %64, %67
  br i1 %68, label %69, label %84

; <label>:69:                                     ; preds = %63
  %70 = load %struct.Node2_struct*, %struct.Node2_struct** %4, align 8
  %71 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %70, i32 0, i32 4
  %72 = load i32, i32* %71, align 8
  %73 = call i32 (i32, ...) bitcast (i32 (...)* @Node2_init to i32 (i32, ...)*)(i32 %72)
  %74 = sext i32 %73 to i64
  %75 = inttoptr i64 %74 to %struct.Node2_struct*
  %76 = load %struct.Node2_struct*, %struct.Node2_struct** %4, align 8
  %77 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %76, i32 0, i32 6
  store %struct.Node2_struct* %75, %struct.Node2_struct** %77, align 8
  %78 = load i32, i32* %3, align 4
  %79 = call i32 (i32, ...) bitcast (i32 (...)* @Node2_init to i32 (i32, ...)*)(i32 %78)
  %80 = sext i32 %79 to i64
  %81 = inttoptr i64 %80 to %struct.Node2_struct*
  %82 = load %struct.Node2_struct*, %struct.Node2_struct** %4, align 8
  %83 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %82, i32 0, i32 7
  store %struct.Node2_struct* %81, %struct.Node2_struct** %83, align 8
  br label %84

; <label>:84:                                     ; preds = %69, %63
  br label %85

; <label>:85:                                     ; preds = %84, %45
  br label %86

; <label>:86:                                     ; preds = %85, %36
  ret void
}

declare i32 @Node2_init(...) #1

; Function Attrs: noinline nounwind optnone uwtable
define i32 @Node2_has(i32, %struct.Node2_struct*) #0 {
  %3 = alloca i32, align 4
  %4 = alloca i32, align 4
  %5 = alloca %struct.Node2_struct*, align 8
  store i32 %0, i32* %4, align 4
  store %struct.Node2_struct* %1, %struct.Node2_struct** %5, align 8
  %6 = load %struct.Node2_struct*, %struct.Node2_struct** %5, align 8
  %7 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %6, i32 0, i32 6
  %8 = load %struct.Node2_struct*, %struct.Node2_struct** %7, align 8
  %9 = icmp eq %struct.Node2_struct* %8, null
  br i1 %9, label %10, label %17

; <label>:10:                                     ; preds = %2
  %11 = load i32, i32* %4, align 4
  %12 = load %struct.Node2_struct*, %struct.Node2_struct** %5, align 8
  %13 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %12, i32 0, i32 4
  %14 = load i32, i32* %13, align 8
  %15 = icmp eq i32 %11, %14
  %16 = zext i1 %15 to i32
  store i32 %16, i32* %3, align 4
  br label %35

; <label>:17:                                     ; preds = %2
  %18 = load i32, i32* %4, align 4
  %19 = load %struct.Node2_struct*, %struct.Node2_struct** %5, align 8
  %20 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %19, i32 0, i32 4
  %21 = load i32, i32* %20, align 8
  %22 = icmp sle i32 %18, %21
  br i1 %22, label %23, label %29

; <label>:23:                                     ; preds = %17
  %24 = load i32, i32* %4, align 4
  %25 = load %struct.Node2_struct*, %struct.Node2_struct** %5, align 8
  %26 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %25, i32 0, i32 6
  %27 = load %struct.Node2_struct*, %struct.Node2_struct** %26, align 8
  %28 = call i32 @Node2_has(i32 %24, %struct.Node2_struct* %27)
  store i32 %28, i32* %3, align 4
  br label %35

; <label>:29:                                     ; preds = %17
  %30 = load i32, i32* %4, align 4
  %31 = load %struct.Node2_struct*, %struct.Node2_struct** %5, align 8
  %32 = getelementptr inbounds %struct.Node2_struct, %struct.Node2_struct* %31, i32 0, i32 7
  %33 = load %struct.Node2_struct*, %struct.Node2_struct** %32, align 8
  %34 = call i32 @Node2_has(i32 %30, %struct.Node2_struct* %33)
  store i32 %34, i32* %3, align 4
  br label %35

; <label>:35:                                     ; preds = %29, %23, %10
  %36 = load i32, i32* %3, align 4
  ret i32 %36
}

attributes #0 = { noinline nounwind optnone uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="false" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #1 = { "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "less-precise-fpmad"="false" "no-frame-pointer-elim"="false" "no-infs-fp-math"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }

!llvm.module.flags = !{!0}
!llvm.ident = !{!1}

!0 = !{i32 1, !"wchar_size", i32 4}
!1 = !{!"clang version 6.0.0-1ubuntu2 (tags/RELEASE_600/final)"}
